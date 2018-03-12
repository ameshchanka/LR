package by.itacademy.controllers;

import by.itacademy.aspects.ErrorCatcher;
import by.itacademy.dto.LeaseDTO;
import by.itacademy.infrastructure.PagingInfo;
import by.itacademy.interfaces.ILeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/lease")
public class LeaseController {

    private ILeaseService leaseService;

    @Autowired
    public LeaseController(ILeaseService leaseService) {
        this.leaseService = leaseService;
    }

    @GetMapping
    @ErrorCatcher
    public String showLeasePage(RedirectAttributes redirectAttributes, Model model, LeaseDTO leaseDTO) {
            Long tempCurrentPage = leaseDTO.getPagingInfo().getCurrentPage() > 1
                    ? leaseDTO.getPagingInfo().getCurrentPage() : 1;
            leaseDTO.getFilter().setFirstItems(tempCurrentPage);

            leaseDTO = leaseService.findLeaseByFilter(leaseDTO);
            leaseDTO.setPagingInfo(new PagingInfo(
                    leaseDTO.getCount(),
                    leaseDTO.getFilter().getCountItems(),
                    tempCurrentPage
            ));
            model.addAttribute("leaseDTO", leaseDTO);
            return "lease";
    }
}
