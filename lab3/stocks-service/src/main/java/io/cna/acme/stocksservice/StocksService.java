package io.cna.acme.stocksservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class StocksService {

    @GetMapping("/recommendation")
    public String getRecommendation() {
        return "PVTL";
    }
}
