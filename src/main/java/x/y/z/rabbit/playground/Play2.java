package x.y.z.rabbit.playground;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/3/26 11:20 下午 Copyright (c) 2016 政采云有限公司
 */
public class Play2 {

    public static void main(String[] args) throws InterruptedException {
//        FileChannel channel = null;
//        try {
//            channel= new FileOutputStream("/Users/isaac/Documents/git-repo/mecodeleet/src/main/java/x/y/z/rabbit/temp/first.txt").getChannel();
//            channel.write(ByteBuffer.wrap("hello nio".getBytes()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                channel.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//        FileChannel fileChannel = null;
//        try {
//            fileChannel = new FileInputStream(
//                "/Users/isaac/Documents/git-repo/mecodeleet/src/main/java/x/y/z/rabbit/temp/first.txt").getChannel();
//            ByteBuffer buffer = ByteBuffer.allocate(1024);
//            fileChannel.read(buffer);
//            buffer.flip();
//            buffer.asLongBuffer().put(212);
//            String encoding =
//                System.getProperty("file.encoding");
//
//            while (buffer.hasRemaining()) {
//                System.out.println(
//                    "0_position: " + buffer.position() + " limit: " + buffer.limit() + " capacity: " + buffer.capacity()
//                        + " mark: " + buffer.mark());
//                System.out.println(Charset.forName(encoding).decode(buffer));
////                System.out.println(buffer.asCharBuffer());
//                System.out.println(
//                    "1_position: " + buffer.position() + " limit: " + buffer.limit() + " capacity: " + buffer.capacity()
//                        + " mark: " + buffer.mark());
////                System.out.write('\n');
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            System.out.flush();
//            try {
//                fileChannel.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//        ByteBuffer buffer = ByteBuffer.allocate(24);
//        IntBuffer intBuffer = buffer.asIntBuffer();
//        intBuffer.put(new int[]{12, 121, 22, 5645, 332, 223});
//        System.out.println(
//            "0_position: " + buffer.position() + " limit: " + buffer.limit() + " capacity: " + buffer
//                .capacity());
//        System.out.println(intBuffer.get(3));
//        intBuffer.put(5,3030);
//        System.out.println(
//            "1_position: " + buffer.position() + " limit: " + buffer.limit() + " capacity: " + buffer
//                .capacity());
//        intBuffer.flip();
//        System.out.println(
//            "2_position: " + buffer.position() + " limit: " + buffer.limit() + " capacity: " + buffer
//                .capacity());
//        while (intBuffer.hasRemaining()) {
//            System.out.println(
//                "3_position: " + buffer.position() + " limit: " + buffer.limit() + " capacity: " + buffer
//                    .capacity());
//            System.out.println(intBuffer.get());
//        ByteBuffer allocate = ByteBuffer.allocate(12);
//
//        long[] array = allocate.asLongBuffer().array();
//        LongBuffer wrap = LongBuffer.wrap(array);
//        RandomAccessFile randomAccessFile = new RandomAccessFile(
//            "/Users/isaac/Documents/git-repo/mecodeleet/src/main/java/x/y/z/rabbit/temp/first.txt",
//            "rw");
//        FileChannel channel = randomAccessFile.getChannel();
//        FileLock lock = channel.lock(0,0x8FFFFFF/3,false);
//        MappedByteBuffer mappedByteBuffer = channel.map(MapMode.READ_WRITE, 0, 0x8FFFFFF);
//        lock.release();
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        ExecutorService exec =
//            Executors.newWorkStealingPool();
//        IntStream.range(0, 10).mapToObj(n -> new Thread(() -> System.out.println(Thread.currentThread().getName()))).forEach(exec::execute);
//        exec.awaitTermination(1, TimeUnit.SECONDS);
        synchronized (Play2.class) {
            TimeUnit.SECONDS.sleep(120);
        }
    }
}
