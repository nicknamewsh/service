package com.pt.ssm.service;

import java.util.Map;

import com.pt.ssm.util.ModelBean;

public interface LoginService {

     ModelBean login(String name, String password);
     ModelBean upRepair(Map<String, Object> paramMap);
     ModelBean wxlogin(String name, String password);

}
