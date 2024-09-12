package com.springInitializer.DemoSpring.Service;


import com.springInitializer.DemoSpring.Entity.Demon;
import com.springInitializer.DemoSpring.Repository.DemonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemonServiceImpl implements DemonService {

    private DemonRepository demonRepository;


    public DemonServiceImpl(DemonRepository demonRepository){
        this.demonRepository = demonRepository;
    }


    @Override
    public Demon saveDemon(Demon demon) {
        return demonRepository.save(demon);
    }

    @Override
    public List<Demon> getAllDemons() {
        return demonRepository.findAll();
    }

    @Override
    public void updateDemon(Demon demon, Long id) {
//        if (!demonRepository.existsById(id)){
//            throw new EntityNotFoundException("Demon with id of " + id + "does not exist");
//        }
        Demon oldDemon = demonRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Demon with id of " + id + "does not exist"));

        oldDemon=demon;
        demonRepository.save(oldDemon);

    }

    @Override
    public Demon getDemonById(Long id) {
        return demonRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Demon with id of " + id + "does not exist"));
    }

    @Override
    public void deleteDemonById(Long id) {
        Demon demon = demonRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Demon with id of " + id + "does not exist !"));
            demonRepository.delete(demon);
    }


}
