package com.happyshop.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.happyshop.dao.CategoryDAO;
import com.happyshop.entity.Category;

@Controller
public class CategoryManger {
    @Autowired
    CategoryDAO dao;
    
    @RequestMapping("/admin/category/index")
    public String index(Model model) {
        Category entity = new Category();
        model.addAttribute("entity", entity);
        model.addAttribute("list", dao.findAll());
        return "admin/category/index";
    }
    
    @RequestMapping("/admin/category/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Category entity = dao.findById(id);
        if(entity == null) {
            // Xử lý trường hợp không tìm thấy đối tượng
            // Ví dụ: Hiển thị thông báo lỗi, chuyển hướng, vv.
            return "redirect:/admin/category/index"; // Chuyển hướng về trang danh sách
        }
        model.addAttribute("entity", entity);
        model.addAttribute("list", dao.findAll());
        return "admin/category/index";
    }
    
    @RequestMapping("/admin/category/create")
    public String create(RedirectAttributes model, @ModelAttribute("entity") Category entity) {
        if(entity == null) {
            // Xử lý trường hợp đối tượng là null
            // Ví dụ: Hiển thị thông báo lỗi, chuyển hướng, vv.
            return "redirect:/admin/category/index"; // Chuyển hướng về trang danh sách
        }
        dao.create(entity);
        model.addAttribute("message", "Thêm mới thành công!");
        return "redirect:/admin/category/index";
    }
    
    @RequestMapping("/admin/category/update")
    public String update(RedirectAttributes model, @ModelAttribute("entity") Category entity) {
        if(entity == null || entity.getId() == null) {
            // Xử lý trường hợp đối tượng là null hoặc không có ID
            // Ví dụ: Hiển thị thông báo lỗi, chuyển hướng, vv.
            return "redirect:/admin/category/index"; // Chuyển hướng về trang danh sách
        }
        dao.update(entity);
        model.addAttribute("message", "Cập nhật thành công!");
        return "redirect:/admin/category/edit/" + entity.getId();
    }
    
    @RequestMapping(value = {"/admin/category/delete","/admin/category/delete/{id}"})
    public String delete(RedirectAttributes model, 
            @RequestParam(value="id", required = false) Integer id1, 
            @PathVariable(value="id", required = false) Integer id2) {
        Integer idToDelete = id1 != null ? id1 : id2;
        if(idToDelete == null) {
            // Xử lý trường hợp không có ID được cung cấp
            // Ví dụ: Hiển thị thông báo lỗi, chuyển hướng, vv.
        	model.addFlashAttribute("error", "Tên loại hoặc tên hãng không phù hợp");
            return "redirect:/admin/category/index"; // Chuyển hướng về trang danh sách
        }
        
        dao.delete(idToDelete);
        model.addAttribute("message", "Xóa thành công!");
        return "redirect:/admin/category/index";
    }
}
