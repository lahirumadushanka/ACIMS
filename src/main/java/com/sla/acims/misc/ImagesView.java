/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sla.acims.misc;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Lt APLM
 */
@ManagedBean
public class ImagesView {
   private List<String> images;
    
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 16; i++) {
            images.add("nature" + i + ".JPG");
        }
    }

    public List<String> getImages() {
        return images;
    }
} 

