package com.happyshop.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.happyshop.dao.OrderDAO;
import com.happyshop.dao.OrderDetailDAO;
import com.happyshop.entity.Order;

@Controller
public class OrderManger {
	@Autowired
	OrderDAO dao;
	
	@Autowired
	OrderDetailDAO ddao;
	
	@RequestMapping("/admin/order/index")
	public String index(Model model) {
	    List<Order> orderList = dao.findAll(); // Lấy danh sách tất cả các đối tượng Order

	    if (!orderList.isEmpty()) { // Kiểm tra nếu danh sách không rỗng
	        Order entity = orderList.get(0); // Lấy đối tượng Order đầu tiên từ danh sách

	        model.addAttribute("entity", entity);
	        model.addAttribute("details", ddao.findByOrder(entity));
	    } else {
	        // Nếu danh sách rỗng, có thể tạo một đối tượng Order mới hoặc xử lý 
	        Order defaultOrder = new Order(); // Tạo một đối tượng Order mặc định
	        model.addAttribute("entity", defaultOrder);
	        model.addAttribute("details", ddao.findByOrder(defaultOrder)); // Lấy chi tiết của đối tượng mặc định (nếu cần)
	    }

	    model.addAttribute("list", orderList);
	    return "admin/order/index";
	}


	
	@RequestMapping("/admin/order/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Order entity = dao.findById(id);
		model.addAttribute("entity", entity);
		model.addAttribute("details", ddao.findByOrder(entity));
		model.addAttribute("list", dao.findAll());
		return "admin/order/index";
	}
	
	@RequestMapping("/admin/order/create")
	public String create(RedirectAttributes model, @ModelAttribute("entity") Order entity) {
		dao.create(entity);
		model.addAttribute("message", "Thêm mới thành công!");
		return "redirect:/admin/order/index";
	}
	
	@PostMapping("/admin/order/update")
	public String update(RedirectAttributes model, @ModelAttribute("entity") Order entity) {
		dao.update(entity);
		model.addAttribute("message", "Cập nhật thành công!");
		return "redirect:/admin/order/edit/"+entity.getId();
	}
	
//	@RequestMapping(value = {"/admin/order/delete","/admin/order/delete/{id}"})
//	public String delete(RedirectAttributes model, 
//			@RequestParam(value="id", required = false) Integer id1, 
//			@PathVariable(value="id", required = false) Integer id2) {
//		if(id1 != null) {
//
//			dao.delete(id1);
//		}else {
//
//			dao.delete(id2);
//		}
//		
//		model.addAttribute("message", "Xóa thành công!");
//		return "redirect:/admin/order/index";
//	}
}
