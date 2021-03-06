package me.wangxhu.leedcode.linkedlist;

import me.wangxhu.leedcode.dfs.ListNode;
import me.wangxhu.leedcode.dfs.TreeNode;
import org.omg.CORBA.INTERNAL;

import java.util.HashSet;
import java.util.Iterator;

/**
 * <p>Created on 18-12-3</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 * <p>
 * <p>
 * leetcode83: 删除排序链表中的重复元素
 * <p>
 * 难度级别: 简单
 */
public class Question83 {

    /**
     * 该方法:超出时间限制
     */
    static class Solution {

        public ListNode deleteDuplicates(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode pre = head;
            ListNode cur = head.next;

            while (pre != null && cur != null) {
                if (pre.val == cur.val) {
                    pre.next = cur.next;
                } else {
                    pre = pre.next;
                    cur = cur.next;
                }
            }
            return head;
        }
    }


    /**
     * 递归实现
     */
    static class Solution1 {

        public ListNode deleteDuplicates(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            head.next = deleteDuplicates(head.next);
            return head.val == head.next.val ? head.next : head;
        }

    }


    /**
     * 非递归实现
     */
    static class Solution2 {

        public ListNode deleteDuplicates(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode cur = head;
            while (cur != null && cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return head;
        }
    }
}
