package by.itacademy.controllers;

import by.itacademy.dto.RoomDto;
import by.itacademy.dto.RoomsObjectDto;
import by.itacademy.entity.RoomsObject;
import by.itacademy.service.RoomsObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    private RoomsObjectService roomsObjectService;

    @Autowired
    public void setRoomsObjectService(RoomsObjectService roomsObjectService) {
        this.roomsObjectService = roomsObjectService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        RoomsObjectDto dto = roomsObjectService.makeModelForIndexPage();
        model.addAttribute("roomsObjectDto", dto);
        return "index";
    }

    @GetMapping("/{id}")
    public String homePage(Model model, @PathVariable("id") Long id) {
        RoomDto dto = roomsObjectService
                .makeModelForHomeRoomsOblectPage(id);
        RoomsObject roomsObject = dto.getRooms()
                .stream()
                .findFirst()
                .get()
                .getRoomsObject();
        model.addAttribute("roomDto", dto);
        model.addAttribute("roomsObject", roomsObject);
        return "homeRoomsOblect";
    }
}
