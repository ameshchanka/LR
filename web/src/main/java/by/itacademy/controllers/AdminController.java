package by.itacademy.controllers;

import by.itacademy.aspects.ErrorCatcher;
import by.itacademy.dto.AddressDto;
import by.itacademy.dto.CityDto;
import by.itacademy.dto.StreetDto;
import by.itacademy.entity.Address;
import by.itacademy.entity.City;
import by.itacademy.entity.Country;
import by.itacademy.entity.Street;
import by.itacademy.service.AddressService;
import by.itacademy.service.CityService;
import by.itacademy.service.CountryService;
import by.itacademy.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
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
        CityDto cityDto = cityService.makeModelCityPage();
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
        StreetDto streetDto = streetService.makeModelStreetPage();
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
        AddressDto addressDto = addressService.makeModelAddressPage();
        model.addAttribute("addressDto", addressDto);
        return "admin/addresses";
    }

    @ErrorCatcher
    @PostMapping("/admin/addresses/create")
    public String createAddresses(RedirectAttributes attr, Address item) {
        addressService.save(item);
        return "redirect:/admin/addresses";
    }

    @ErrorCatcher
    @PostMapping("/admin/addresses/edit")
    public String editAddresses(RedirectAttributes attr, Address item) {
        addressService.update(item);
        return "redirect:/admin/addresses";
    }

    @ErrorCatcher
    @PostMapping("/admin/addresses/delete")
    public String deleteAddresses(RedirectAttributes attr, long id) {
        addressService.delete(id);
        return "redirect:/admin/addresses";
    }
    //endregion
}
