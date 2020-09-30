package feign;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tz_category")
public class Category {

    @TableId
    private Long categoryId;


    private Long shopId;


    private Long parentId;


    private String categoryName;
}
