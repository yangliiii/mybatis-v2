package com.yangli.mybatis.lombok;

import lombok.Data;
import lombok.Setter;

/**
 * Created by lies on 2018/3/26.
 */
@Setter
@Data
public class ELombok {

    private String username;
    private String pwd;
    private String nickname;
    private String addr;
}
