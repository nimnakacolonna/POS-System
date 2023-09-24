package com.springbootacademytwo.batch7newpos.controller;

import com.springbootacademytwo.batch7newpos.dto.request.ItemSaveRequestDTO;
import com.springbootacademytwo.batch7newpos.dto.response.ItemGetResponseDTO;
import com.springbootacademytwo.batch7newpos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController  {

@Autowired
    private ItemService itemService;

@PostMapping(
        path={"/save"}
)
public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){

    String message = itemService.saveItem(itemSaveRequestDTO);
    return "saved";
}
@GetMapping(
        path = "/get-by-name",
        params = "name"
)
    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam(value = "name") String itemName){
    List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatus(itemName);
    return itemDTOS;
}

}
