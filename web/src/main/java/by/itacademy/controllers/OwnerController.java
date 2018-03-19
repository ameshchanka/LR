package by.itacademy.controllers;

import by.itacademy.aspects.ErrorCatcher;
import by.itacademy.dto.RoomDto;
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
        //roomDto.getUser().setEmail(getAuthenticationUser().getEmail());
        roomDto.getUser().setEmail("manager@mail.com");// альтернатива коду выше

        RoomDto dto = roomService.makeModelForRoomsPage(roomDto);
        model.addAttribute("roomDto", dto);
        return "owner/rooms";
    }
//<form class="edit-room-0" role="form" th:action="@{/owner/rooms/create}" method="post">
//     <form th:id="'edit-room-' + ${room.id}" role="form" action="/owner/rooms/edit" method="post">
//<form th:id="'delete-room-' + ${room.id}" role="form" action="/owner/rooms/delete" method="post">
//                <input type="hidden" name="id" th:value="${room.id}"/>
//            </form>
//            <form th:id="'start-lease-' + ${room.id}" role="form" action="/owner/rooms/startlease" method="post">
//                <input type="hidden" name="id" th:value="${room.id}"/>
//            </form>
//            <form th:id="'stop-lease-' + ${room.id}" role="form" action="/owner/rooms/stoplease" method="post">
//                <input type="hidden" name="id" th:value="${room.id}"/>
//            </form>

    @ErrorCatcher
    @PostMapping("/owner/rooms/create")
    public String createRoom(RedirectAttributes attr, Room room) {
        //room.setUser(getAuthenticationUser());
        room.setUser(new User());                       // альтернатива
        room.getUser().setEmail("manager@mail.com");    // коду выше
        roomService.save(room);
        return "redirect:/owner/rooms";
    }

    @ErrorCatcher
    @PostMapping("/owner/rooms/edit")
    public String updateRoom(RedirectAttributes attr, Room room) {
        //room.setUser(getAuthenticationUser());
        room.setUser(new User());                       // альтернатива
        room.getUser().setEmail("manager@mail.com");    // коду выше
        roomService.update(room);
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

    private User getAuthenticationUser() {
        User user = new User();
        user.setEmail(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal().toString());
        return user;
    }
}
