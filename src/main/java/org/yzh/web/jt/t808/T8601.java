package org.yzh.web.jt.t808;

import org.yzh.framework.orm.annotation.Property;
import org.yzh.framework.orm.annotation.Type;
import org.yzh.framework.enums.DataType;
import org.yzh.framework.orm.model.AbstractBody;
import org.yzh.web.jt.common.JT808;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhihao.ye (1527621790@qq.com)
 * @home http://gitee.com/yezhihao/jt-server
 */
@Type({JT808.删除圆形区域, JT808.删除矩形区域, JT808.删除多边形区域})
public class T8601 extends AbstractBody {

    private Integer total;
    private List<Item> items;

    @Property(index = 0, type = DataType.BYTE, desc = "区域总数")
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Property(index = 1, type = DataType.LIST, desc = "区域列表")
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        this.total = items.size();
    }

    public void addItem(Integer id) {
        if (items == null)
            items = new ArrayList();
        items.add(new Item(id));
        total = items.size();
    }

    public static class Item {
        private Integer id;

        public Item() {
        }

        public Item(Integer id) {
            this.id = id;
        }

        @Property(index = 0, type = DataType.DWORD, desc = "区域ID")
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}