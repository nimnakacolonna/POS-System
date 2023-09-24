package com.springbootacademytwo.batch7newpos.service;

import com.springbootacademytwo.batch7newpos.dto.request.ItemSaveRequestDTO;
import com.springbootacademytwo.batch7newpos.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);
}
