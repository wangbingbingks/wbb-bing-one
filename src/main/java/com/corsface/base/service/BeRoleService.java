package com.corsface.base.service;

import com.corsface.base.dao.BeRoleDao;
import com.corsface.base.entity.BeRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeRoleService {

    @Autowired
    private BeRoleDao beRoleDao;

    public List<BeRole> getAllRole() {
        return beRoleDao.getAllRole();
    }
}
