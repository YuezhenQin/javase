package IO;

import java.nio.ByteBuffer;

public class ByteBufferDemo {
    public static void show(ByteBuffer buffer) {
        System.out.println("bytebuffer: position="+buffer.position()+" limit="+buffer.limit()+" capacity="+buffer.capacity());
    }
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putInt(1);
        show(buffer);
        //直接缓冲区主要分配给受底层系统 I/O 操作影响较多的、大型的、长期存在的数据。
    }
}
