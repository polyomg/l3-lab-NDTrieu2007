package com.poly.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.poly.entity.*;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    // Dùng Map để chứa các mặt hàng, key là id của mặt hàng
    Map<Integer, Item> map = new HashMap<>();

    @Override
    public Item add(Integer id) {
        // Kiểm tra xem mặt hàng đã tồn tại trong giỏ chưa
        Item item = map.get(id);
        if (item == null) {
            // Nếu chưa có, tạo mới (dữ liệu mẫu — thực tế có thể lấy từ DB)
            item = new Item(id, "Sản phẩm " + id, 100.0, 1);
            map.put(id, item);
        } else {
            // Nếu có rồi thì tăng số lượng lên 1
            item.setQty(item.getQty() + 1);
        }
        return item;
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public Item update(Integer id, int qty) {
        Item item = map.get(id);
        if (item != null) {
            item.setQty(qty);
        }
        return item;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    @Override
    public int getCount() {
        return map.values().stream()
                .mapToInt(Item::getQty)
                .sum();
    }

    @Override
    public double getAmount() {
        return map.values().stream()
                .mapToDouble(i -> i.getPrice() * i.getQty())
                .sum();
    }
}
