package com.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "wm_cheats")
public class Cheats {

    @Id
    private int id;

    //秘籍名称
    private String cheatsName;

    //用户id
    @Column(name = "user_id")
    private String userId;

    //冲泡详情id
    @Column(name = "detail_id")
    private int detailId;

}
