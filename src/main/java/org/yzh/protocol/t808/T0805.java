package org.yzh.protocol.t808;

import io.github.yezhihao.netmc.core.model.Response;
import io.github.yezhihao.protostar.DataType;
import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import org.yzh.protocol.basics.JTMessage;
import org.yzh.protocol.commons.JT808;

/**
 * @author yezhihao
 * @home https://gitee.com/yezhihao/jt808-server
 */
@Message(JT808.摄像头立即拍摄命令应答)
public class T0805 extends JTMessage implements Response {

    private int responseSerialNo;
    private int result;
    private int total;
    private int[] id;

    @Field(index = 0, type = DataType.WORD, desc = "应答流水号")
    public int getResponseSerialNo() {
        return responseSerialNo;
    }

    public void setResponseSerialNo(int responseSerialNo) {
        this.responseSerialNo = responseSerialNo;
    }

    @Field(index = 2, type = DataType.BYTE, desc = "结果: 0.成功 1.失败 2.通道不支持")
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Field(index = 2, type = DataType.WORD, desc = "多媒体ID个数")
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Field(index = 4, type = DataType.DWORD, desc = "多媒体ID列表")
    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
        this.total = id.length;
    }
}