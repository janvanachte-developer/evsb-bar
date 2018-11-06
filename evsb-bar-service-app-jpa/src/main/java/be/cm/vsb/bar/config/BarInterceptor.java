package be.cm.vsb.bar.config;

import be.cm.vsb.bar.Bar;
import org.hibernate.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

public class BarInterceptor extends EmptyInterceptor {

    @Override
    public Object instantiate(String entityName, EntityMode entityMode, Serializable id) {

        System.out.println("################## entityName=" + entityName + " entityMode="+entityMode+" id="+id);

        if ("be.cm.vsb.bar.Bar".equalsIgnoreCase(entityName)) {
            return Bar.builder().identifier((String) id).build();
        } else {
            return null; // use hibernate default behaviour
        }
    }
}
