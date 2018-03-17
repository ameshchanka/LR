package by.itacademy.controllers;

import by.itacademy.aspects.ErrorCatcher;
import by.itacademy.dto.AddressDto;
import by.itacademy.dto.CityDto;
import by.itacademy.dto.LeaseAdDto;
import by.itacademy.dto.RoomsObjectDto;
import by.itacademy.dto.StreetDto;
import by.itacademy.dto.UserDto;
import by.itacademy.entity.Address;
import by.itacademy.entity.City;
import by.itacademy.entity.Country;
import by.itacademy.entity.RoomsObject;
import by.itacademy.entity.RoomsObjectInformation;
import by.itacademy.entity.Street;
import by.itacademy.entity.User;
import by.itacademy.service.AddressService;
import by.itacademy.service.CityService;
import by.itacademy.service.CountryService;
import by.itacademy.service.LeaseAdService;
import by.itacademy.service.RoomsObjectInformationService;
import by.itacademy.service.RoomsObjectService;
import by.itacademy.service.StreetService;
import by.itacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminController {

    private CountryService countryService;
    private CityService cityService;
    private StreetService streetService;
    private AddressService addressService;
    private RoomsObjectService roomsObjectService;
    private RoomsObjectInformationService roomsObjectInformationService;
    private LeaseAdService leaseAdService;
    private UserService userService;

    //@ExceptionHandler - прочитать
    //region @Autowired
    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @Autowired
    public void setStreetService(StreetService streetService) {
        this.streetService = streetService;
    }

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @Autowired
    public void setRoomsObjectService(RoomsObjectService roomsObjectService) {
        this.roomsObjectService = roomsObjectService;
    }

    @Autowired
    public void setRoomsObjectInformationService(RoomsObjectInformationService roomsObjectInformationService) {
        this.roomsObjectInformationService = roomsObjectInformationService;
    }

    @Autowired
    public void setLeaseAdService(LeaseAdService leaseAdService) {
        this.leaseAdService = leaseAdService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    //endregion

    @GetMapping("/admin")
    public String showAdminPage() {
        return "redirect:admin/countries";
    }

    //region Country
    @ErrorCatcher
    @GetMapping("/admin/countries")
    public String showCountriesPage(RedirectAttributes attr, Model model) {
        Iterable<Country> countries = countryService.findAll();
        model.addAttribute("countries", countries);
        return "admin/countries";
    }

    @ErrorCatcher
    @PostMapping("/admin/countries/create")
    public String createCountry(RedirectAttributes attr, Country item) {
        countryService.save(item);
        return "redirect:/admin/countries";
    }

    @ErrorCatcher
    @PostMapping("/admin/countries/edit")
    public String editCountry(RedirectAttributes attr, Country item) {
        countryService.update(item);
        return "redirect:/admin/countries";
    }

    @ErrorCatcher
    @PostMapping("/admin/countries/delete")
    public String deleteCountry(RedirectAttributes attr, long id) {
        countryService.delete(id);
        return "redirect:/admin/countries";
    }
    //endregion

    //region City
    @ErrorCatcher
    @GetMapping("/admin/cities")
    public String showCitiesPage(RedirectAttributes attr, Model model) {
        CityDto cityDto = cityService.makeModelForCityPage();
        model.addAttribute("cityDto", cityDto);
        return "admin/cities";
    }

    @ErrorCatcher
    @PostMapping("/admin/cities/create")
    public String createCity(RedirectAttributes attr, City item) {
        cityService.save(item);
        return "redirect:/admin/cities";
    }

    @ErrorCatcher
    @PostMapping("/admin/cities/edit")
    public String editCity(RedirectAttributes attr, City item) {
        cityService.update(item);
        return "redirect:/admin/cities";
    }

    @ErrorCatcher
    @PostMapping("/admin/cities/delete")
    public String deleteCity(RedirectAttributes attr, long id) {
        cityService.delete(id);
        return "redirect:/admin/cities";
    }
    //endregion

    //region Street
    @ErrorCatcher
    @GetMapping("/admin/streets")
    public String showStreetsPage(RedirectAttributes attr, Model model) {
        StreetDto streetDto = streetService.makeModelForStreetPage();
        model.addAttribute("streetDto", streetDto);
        return "admin/streets";
    }

    @ErrorCatcher
    @PostMapping("/admin/streets/create")
    public String createStreet(RedirectAttributes attr, Street item) {
        streetService.save(item);
        return "redirect:/admin/streets";
    }

    @ErrorCatcher
    @PostMapping("/admin/streets/edit")
    public String editStreet(RedirectAttributes attr, Street item) {
        streetService.update(item);
        return "redirect:/admin/streets";
    }

    @ErrorCatcher
    @PostMapping("/admin/streets/delete")
    public String deleteStreet(RedirectAttributes attr, long id) {
        streetService.delete(id);
        return "redirect:/admin/streets";
    }
    //endregion

    //region Address
    @ErrorCatcher
    @GetMapping("/admin/addresses")
    public String showAddressesPage(RedirectAttributes attr, Model model) {
        AddressDto addressDto = addressService.makeModelForAddressPage();
        model.addAttribute("addressDto", addressDto);
        return "admin/addresses";
    }

    @ErrorCatcher
    @PostMapping("/admin/addresses/create")
    public String createAddress(RedirectAttributes attr, Address item) {
        addressService.save(item);
        return "redirect:/admin/addresses";
    }

    @ErrorCatcher
    @PostMapping("/admin/addresses/edit")
    public String editAddress(RedirectAttributes attr, Address item) {
        addressService.update(item);
        return "redirect:/admin/addresses";
    }

    @ErrorCatcher
    @PostMapping("/admin/addresses/delete")
    public String deleteAddress(RedirectAttributes attr, long id) {
        addressService.delete(id);
        return "redirect:/admin/addresses";
    }
    //endregion

    //region RoomsObject
    @ErrorCatcher
    @GetMapping("/admin/roomsobjects")
    public String showRoomsObjectsPage(RedirectAttributes attr, Model model) {
        RoomsObjectDto dto = roomsObjectService.makeModelForRoomsObjectPage();
        model.addAttribute("roomsObjectDto", dto);
        return "admin/roomsobjects";
    }

    @ErrorCatcher
    @PostMapping("/admin/roomsobjects/create")
    public String createRoomsObject(RedirectAttributes attr, RoomsObject item) {
        roomsObjectService.save(item);
        return "redirect:/admin/roomsobjects";
    }

    @ErrorCatcher
    @PostMapping("/admin/roomsobjects/edit")
    public String editRoomsObject(RedirectAttributes attr, Model model, RoomsObject item) {
        try {
            roomsObjectService.update(item);
        } catch (ObjectOptimisticLockingFailureException e) {
            RoomsObject itemSave = roomsObjectService.findById(item.getId());
            model.addAttribute("roomsObject", item);
            model.addAttribute("roomsObjectSave", itemSave);
            return "admin/roomsobjectinfo";
        }
        return "redirect:/admin/roomsobjects";
    }

    @ErrorCatcher
    @PostMapping("/admin/roomsobjects/delete")
    public String deleteRoomsObject(RedirectAttributes attr, long id) {
        roomsObjectService.delete(id);
        return "redirect:/admin/roomsobjects";
    }

    @ErrorCatcher
    @PostMapping("/admin/roomsobjectinfo/edit")
    public String editRoomsObject(RedirectAttributes attr, Model model, RoomsObjectInformation item) {
        roomsObjectInformationService.update(item);
        return "redirect:/admin/roomsobjects";
    }

    //endregion

    //region LeaseAds
    @ErrorCatcher
    @GetMapping("/admin/leaseads")
    public String showLeaseAdsPage(RedirectAttributes attr, Model model, LeaseAdDto leaseAdDto) {
        LeaseAdDto dto = leaseAdService.makeModelForLeaseAdPage(leaseAdDto);
        model.addAttribute("leaseAdDto", dto);
        return "admin/leaseads";
    }

    @ErrorCatcher
    @PostMapping("/admin/leaseads/delete")
    public String deleteRoom(RedirectAttributes attr, long id) {
        leaseAdService.delete(id);
        return "redirect:/admin/leaseads";
    }
    //endregion

    //region Users
    @ErrorCatcher
    @GetMapping("/admin/users")
    public String showUsersPage(RedirectAttributes attr, Model model) {
        UserDto dto = userService.makeModelForUsersPage();
        model.addAttribute("usersDto", dto);
        return "admin/users";
    }

    @ErrorCatcher
    @PostMapping("/admin/users/adrole")
    public String editUser(RedirectAttributes attr, User item) {
        userService.adRole(item);
        return "redirect:/admin/users";
    }

    @ErrorCatcher
    @PostMapping("/admin/users/delete")
    public String deleteUser(RedirectAttributes attr, long id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }
    //endregion
}
