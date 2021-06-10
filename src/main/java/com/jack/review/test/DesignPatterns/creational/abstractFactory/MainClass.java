package com.jack.review.test.DesignPatterns.creational.abstractFactory;

/**
 * @Description: 抽象工厂模式
 * @Auther: Jack You
 * @Date: 2021/05/28/17:59
 */
public class MainClass {
    /*当涉及到这种产品族的问题的时候，就需要抽象工厂模式来支持了。
    我们不再定义 CPU 工厂、主板工厂、硬盘工厂、显示屏工厂等等，我们直接定义电脑工厂，
    每个电脑工厂负责生产所有的设备，这样能保证肯定不存在兼容问题*/
    public static void main(String[] args) {
        // 第一步就要选定一个“大厂”
        ComputerFactory cf = new AmdFactory();
        // 从这个大厂造 CPU
        CPU cpu = cf.makeCPU();
        // 从这个大厂造主板
        MainBoard board = cf.makeMainBoard();
        // 从这个大厂造硬盘
        /*HardDisk hardDisk = cf.makeHardDisk();*/

        // 将同一个厂子出来的 CPU、主板、硬盘组装在一起
        /*Computer result = new Computer(cpu, board, hardDisk);*/
    }
}
