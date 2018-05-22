package com.graduate.bsms.controller;

import com.graduate.bsms.pojo.Cardtype;
import com.graduate.bsms.service.CardtypeService;
import com.graduate.bsms.util.UUIDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Admin on 2018/5/15.
 */
@Controller
@RequestMapping("cardType")
public class CardTypeController {
    @Autowired
    private CardtypeService cardtypeService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String showIndex(Model model) {
        return "cardType/index";
    }

    @RequestMapping(value = "selectAll", method = RequestMethod.POST)
    public @ResponseBody
    List<Cardtype> selectList(Model model) {
        return cardtypeService.selectAll();
    }

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public @ResponseBody
    List<Cardtype> getAll(Model model) {
        return cardtypeService.selectAll();
    }

    @RequestMapping(value = "showAddCardType", method = RequestMethod.GET)
    public String showAddCardType() {
        return "cardType/add";
    }

    @RequestMapping(value = "cardTypeInsert", method = RequestMethod.POST)
    public @ResponseBody
    int insert(String name, double discount
    ) throws Exception {
        Cardtype cardType = new Cardtype();
        cardType.setDiscount(discount);
        cardType.setName(name);
        cardType.setStatus(0);
        cardType.setId(UUIDFactory.getUUID());
        return this.cardtypeService.insert(cardType);
    }

    @RequestMapping(value = "showUpdateCardType", method = RequestMethod.GET)
    public String showUpdateRole(Model model, String id) {
        model.addAttribute("id", id);
        return "cardType/update";
    }

    @RequestMapping(value = "cardTypeById", method = RequestMethod.POST)
    public @ResponseBody
    Cardtype selectByPrimaryKey(String id) {
        return this.cardtypeService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "cardTypeUpdate", method = RequestMethod.POST)
    public @ResponseBody
    int updateByPrimaryKey(String id, String name, Double discount
    ) throws Exception {
        Cardtype cardtype = new Cardtype();
        cardtype.setId(id);
        cardtype.setName(name);
        cardtype.setDiscount(discount);
        cardtype.setStatus(0);
        return this.cardtypeService.updateByPrimaryKey(cardtype);
    }

    @RequestMapping(value = "cardTypeDeleteById", method = RequestMethod.POST)
    public @ResponseBody
    int deleteByPrimaryKey(String id) {
        return this.cardtypeService.deleteByPrimaryKey(id);
    }
}
