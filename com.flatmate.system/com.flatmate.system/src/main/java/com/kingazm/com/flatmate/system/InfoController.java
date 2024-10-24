package com.kingazm.com.flatmate.system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {
    @GetMapping("/info")
    public String showFlatInfo(Model model) throws ClassNotFoundException {

        String addressInfo = InfoService.getAddressInfo();
        model.addAttribute("addressInfo", addressInfo);

        String wifiName = InfoService.getWiFiName();
        model.addAttribute("wifiName", wifiName);

        String wifiPassword = InfoService.getWiFiPassword();
        model.addAttribute("wifiPassword", wifiPassword);

        return "info";
    }

}
