package DoAnLapTrinhUngDung.totgokhung123;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {
    @GetMapping
    public String test(){
        return "templates/html/index";
    }
}
