package by.itacademy.controllers;

import by.itacademy.aspects.ErrorCatcher;
import by.itacademy.dto.LeaseRoomsDto;
import by.itacademy.service.LeaseRoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/leaserooms")
public class LeaseRoomsController {

    private LeaseRoomsService leaseService;

    @Autowired
    public void setLeaseService(LeaseRoomsService leaseService) {
        this.leaseService = leaseService;
    }

    @GetMapping
    @ErrorCatcher
    public String showLeasePage(RedirectAttributes redirectAttributes, Model model, LeaseRoomsDto leaseRoomsDto) {
//            Long tempCurrentPage = leaseRoomsDTO.getPaging().getCurrentPage() > 1
//                    ? leaseRoomsDTO.getPaging().getCurrentPage() : 1;
//            leaseRoomsDTO.getFilter().setFirstItems(tempCurrentPage);

            LeaseRoomsDto dto = leaseService.makeModelForLeaseRoomsPage(leaseRoomsDto);
//            leaseRoomsDTO.setPaging(new PagingInfo(
//                    leaseRoomsDTO.getCount(),
//                    leaseRoomsDTO.getFilter().getCountItems(),
//                    tempCurrentPage
//            ));
            model.addAttribute("leaseRoomsDto", dto);
            return "leaserooms";
    }
}
