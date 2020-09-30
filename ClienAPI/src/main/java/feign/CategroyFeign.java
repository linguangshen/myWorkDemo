package feign;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("eurka-clien1")
@RequestMapping("/ceshi")
public interface CategroyFeign {
    @RequestMapping("/ceshi")
    public List<Category> query();
}
