package by.itacademy.controllers;

import by.itacademy.aspects.ErrorCatcher;
import by.itacademy.dto.RoomDto;
import by.itacademy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
//        roomDto.getUser()
//                .setEmail(SecurityContextHolder
//                        .getContext()
//                        .getAuthentication()
//                        .getPrincipal().toString());
        roomDto.getUser().setEmail("manager@mail.com");
        RoomDto dto = roomService.makeModelForRoomsPage(roomDto);
        model.addAttribute("roomDto", dto);
        return "owner/rooms";
    }

//    @ErrorCatcher
//    @PostMapping("/admin/leaseads/delete")
//    public String deleteRoom(RedirectAttributes attr, long id) {
//        leaseAdService.delete(id);
//        return "redirect:/admin/leaseads";
//    }
}
