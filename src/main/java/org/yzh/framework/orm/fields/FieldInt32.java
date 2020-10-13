package org.yzh.framework.orm.fields;

import io.netty.buffer.ByteBuf;
import org.yzh.framework.orm.FieldMetadata;

import java.lang.reflect.Method;

public class FieldInt32 extends FieldMetadata<Integer> {

    public FieldInt32(int index, int length, String desc, Method readMethod, Method writeMethod, Method lengthMethod) {
        super(index, length, desc, readMethod, writeMethod, lengthMethod);
    }

    @Override
    public Integer readValue(ByteBuf buf, int length) {
        return (int) buf.readUnsignedInt();
    }

    @Override
    public void writeValue(ByteBuf buf, Integer value) {
        buf.writeInt(value);
    }
}