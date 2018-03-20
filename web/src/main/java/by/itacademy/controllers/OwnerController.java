package by.itacademy.controllers;

import by.itacademy.aspects.ErrorCatcher;
import by.itacademy.dto.RoomDto;
import by.itacademy.dto.RoomUpdateDto;
import by.itacademy.entity.Room;
import by.itacademy.entity.User;
import by.itacademy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OwnerController {

    private RoomService roomService;

    @Autowired
    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/owner")
    public String showOwnerPage() {
        return "redirect:/owner/rooms";
    }


    //region LeaseAds
    @ErrorCatcher
    @GetMapping("/owner/rooms")
    public String showRoomsPage(RedirectAttributes attr, Model model, RoomDto roomDto) {
        roomDto.getUser().setEmail(getAuthenticationUserEmail());
        RoomDto dto = roomService.makeModelForRoomsPage(roomDto);
        model.addAttribute("roomDto", dto);
        return "owner/rooms";
    }

    @ErrorCatcher
    @PostMapping("/owner/rooms/create")
    public String createRoom(RedirectAttributes attr, Room room) {
        room.setUser(new User());
        room.getUser().setEmail(getAuthenticationUserEmail());
        roomService.save(room);
        return "redirect:/owner/rooms";
    }

    @ErrorCatcher
    @PostMapping("/owner/rooms/edit")
    public String updateRoom(RedirectAttributes attr, RoomUpdateDto dto) {
        dto.getRoom().setUser(new User());
        dto.getRoom().getUser().setEmail(getAuthenticationUserEmail());
        roomService.update(dto);
        return "redirect:/owner/rooms";
    }

    @ErrorCatcher
    @PostMapping("/owner/rooms/delete")
    public String deleteRoom(RedirectAttributes attr, long id) {
        roomService.delete(id);
        return "redirect:/owner/rooms";
    }

    @ErrorCatcher
    @PostMapping("/owner/rooms/startlease")
    public String startleaseRoom(RedirectAttributes attr, long id) {
        roomService.startlease(id);
        return "redirect:/owner/rooms";
    }

    @ErrorCatcher
    @PostMapping("/owner/rooms/stoplease")
    public String stopleaseRoom(RedirectAttributes attr, long id) {
        roomService.stoplease(id);
        return "redirect:/owner/rooms";
    }

    private String getAuthenticationUserEmail() {
        org.springframework.security.core.userdetails.User user
                = (org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return user.getUsername();
    }
}
