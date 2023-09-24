package com.springbootacademytwo.batch7newpos.service.impl;

import com.springbootacademytwo.batch7newpos.dto.request.ItemSaveRequestDTO;
import com.springbootacademytwo.batch7newpos.dto.response.ItemGetResponseDTO;
import com.springbootacademytwo.batch7newpos.entity.Customer;
import com.springbootacademytwo.batch7newpos.entity.Item;
import com.springbootacademytwo.batch7newpos.repo.ItemRepo;
import com.springbootacademytwo.batch7newpos.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {

        Item item = modelMapper.map(itemSaveRequestDTO,Item.class);
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return item.getItemId()+"saved Succesfully";
        }else {
            throw new DuplicateKeyException("already added");
        }


    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
        boolean b = true;
        List<Item> items = itemRepo.findAllByItemnameEqualsAndActiveStateEquals(itemName, b);
        if (items.size() > 0) {
            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(items, new TypeToken<List<ItemGetResponseDTO>>() {
            }.getType());
            return itemGetResponseDTOS;
        } else {
throw new RuntimeException("Not Found");
        }

    }
}
