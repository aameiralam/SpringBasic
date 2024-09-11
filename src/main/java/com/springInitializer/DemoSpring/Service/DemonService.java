package com.springInitializer.DemoSpring.Service;

import com.springInitializer.DemoSpring.Entity.Demon;

import java.util.List;

public interface DemonService {

        Demon saveDemon(Demon demon);

        List<Demon> getAllDemons();

        void updateDemon(Demon demon, Long id);

        Demon getDemonById(Long id);

}
