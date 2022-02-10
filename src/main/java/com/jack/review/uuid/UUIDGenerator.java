package com.jack.review.uuid;


import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.*;

public class UUIDGenerator {

    private String bizCode;

    public UUIDGenerator(String bizCode) {
        this.bizCode = bizCode;
    }

    private static Integer THREANDS = 1000000;
    private ExecutorService executorService = Executors.newCachedThreadPool();


    public static void main(String[] args) throws InterruptedException {
        UUIDGenerator uuidGenerator = new UUIDGenerator("");
        uuidGenerator.test();
    }

    public void test() throws InterruptedException {
        ConcurrentHashMap<Integer, String> idMap = new ConcurrentHashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(THREANDS);
        for (int i = 0; i <= THREANDS; i++) {
            int finalI = i;
            executorService.execute(() -> {
                countDownLatch.countDown();
                UUIDGenerator uuidGenerator = new UUIDGenerator("编码");
                String id = uuidGenerator.generateUId();
                idMap.put(finalI,Thread.currentThread().getName() + " : " + id);
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
        Map<Integer, String> integerStringMap = sortMapByKey(idMap);
        System.out.println(integerStringMap);
    }


    public static Map<Integer, String> sortMapByKey(Map<Integer, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<Integer, String> sortMap = new TreeMap<>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }
    static private String generateUId() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}

class MapKeyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
