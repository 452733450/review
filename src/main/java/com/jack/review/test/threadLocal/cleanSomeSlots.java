//package com.jack.review.test.threadLocal;
//
///**
// * @Description:
// * @Auther: Jack You
// * @Date: 2021/06/24/17:14
// */
//public class cleanSomeSlots {
//    /**
//     主要作用：
//     进行一定次数的循环，从当位置i开始往后寻找脏entry并清理掉，当清理脏entry时，使用expungeStaleEntry方法，从当前脏entry会再往后寻找脏entry进行清理，碰到null时结束。
//     可以看到这个清理的过程只是覆盖了一段范围，并不是全部区间。
//     */
//    private boolean cleanSomeSlots(int i, int n) {
//        boolean removed = false;
//        Entry[] tab = table;
//        int len = tab.length;
//        do {
//            i = nextIndex(i, len);
//            Entry e = tab[i];
//            if (e != null && e.get() == null) {
//                n = len;
//                removed = true;
//                i = expungeStaleEntry(i);
//            }
//        } while ( (n >>>= 1) != 0);
//        return removed;
//    }
//
//    /*主要作用：
//    循环的去寻找脏Entry，即key=null的Entry，然后进行删除。
//
//    详细说明：
//    n >>>= 1 说明要循环log2N次。在没有发现脏Entry时，会一直往后找下个位置的entry是否是脏的，如果是的话，就会使 n = 数组的长度。然后继续循环log2新N 次。*/
//
//    /**
//     主要作用：从当前位置开始，往后再找一段，碰到脏entry进行清理，碰到null结束
//     */
//    private int expungeStaleEntry(int staleSlot) {
//        // 1. 将当前的脏entry 置为null,value 置为 null, size,即entry 的数量 减一
//        Entry[] tab = table;
//        int len = tab.length;
//
//        // expunge entry at staleSlot
//        tab[staleSlot].value = null;
//        tab[staleSlot] = null;
//        size--;
//
//        // Rehash until we encounter null
//        Entry e;
//        int i;
//        // 依次循环的使index往后移，直到找到一个 entry = null ，则退出，并返回这个 index
//        for (i = nextIndex(staleSlot, len);
//             (e = tab[i]) != null;
//             i = nextIndex(i, len)) {
//            ThreadLocal<?> k = e.get();
//            // 在这个过程中，发现脏entry就清除掉
//            if (k == null) {
//                e.value = null;
//                tab[i] = null;
//                size--;
//            } else {
//                /**
//                 因为 ThreadLocalMap 的处理冲突的方式是循环看下index 的 entry是否为null,如果是，就插入，
//                 而不像hashMap那样，通过key的hashcode就能定位到一定是在某个位置的。这里就检查了下如果rehash发现h==i,
//                 则说明当初添加的时候，没有冲突，直接放进了这个位置。否则，则说明当初加入的时候，发生了冲突，然后往后遍历，
//                 寻找空位放入了。于是，当h != i时，其实又执行了原来的过程，即将当前位置entry放到index=h位，
//                 如果存在冲突就往后找空位放入，然后将原来的位置的位置腾出来。
//
//                 目前来看这样做，是每次都进行了位置的调整，使得删除所得的空位置可以尽量的被利用起来，还没看出有什么好处？但是其实不这么做，下个key要插入时，因为是循环定位，因此，被腾出来的位置还是会被使用掉的，也不影响。
//                 */
//                int h = k.threadLocalHashCode & (len - 1);
//                if (h != i) {
//                    tab[i] = null;
//
//                    // Unlike Knuth 6.4 Algorithm R, we must scan until
//                    // null because multiple entries could have been stale.
//                    while (tab[h] != null)
//                        h = nextIndex(h, len);
//                    tab[h] = e;
//                }
//            }
//        }
//        return i;
//    }
//
//}
