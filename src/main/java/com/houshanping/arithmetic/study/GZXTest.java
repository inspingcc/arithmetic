package main.java.com.houshanping.arithmetic.study;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: houshanping
 * @Date: 2020/02/26 17:22
 */
public class GZXTest {
    public static final int MAX_LEVEL = 10;
    public static final String HEAD_NODE_NAME = "head";

    public static void main(String[] args) {
        Model model2 = new Model("生活用品", "吃的", null, null, null, null, null, null, null, null);
        Model model3 = new Model("喝的", "水", null, null, null, null, null, null, null, null);
        Model model4 = new Model("生活用品", "喝的", "水", null, null, null, null, null, null, null);
        Model model1 = new Model("水", "喝的", "水", "水", "水", "水", "水", "水", "水", null);
        List<Model> list = new ArrayList<>();
        list.add(model1);
        list.add(model2);
        list.add(model3);
        list.add(model4);
        ModelTreeNode head = process(list);
        System.out.println(head);
    }

    private static ModelTreeNode process(List<Model> list) {
        ModelTreeNode head = new ModelTreeNode(HEAD_NODE_NAME, null);
        for (int i = 0; i < MAX_LEVEL; i++) {
            ModelTreeNode curFirst = null;
            ModelTreeNode curTail = null;
            for (int j = 0; j < list.size(); j++) {
                Model model = list.get(j);
                if (model == null) {
                    continue;
                }
                String name = model.getTypeIndex(i);
                if (name == null) {
                    continue;
                }
                // 查找前置兄弟节点
                boolean exist = false;
                ModelTreeNode curBrotherNode = curFirst;
                while (curBrotherNode != null) {
                    if (compareModel(model, curBrotherNode.model, i)) {
                        exist = true;
                        break;
                    }
                    curBrotherNode = curBrotherNode.getLeftNode();
                }
                // 当前节点不存在
                if (!exist) {
                    // 新节点
                    ModelTreeNode newNode = new ModelTreeNode(name, model);
                    // 查找父节点
                    ModelTreeNode preParentNode = head;
                    if (i > 0) {
                        preParentNode = searchParent(head, model, i - 1);
                    }
                    preParentNode.addChild(newNode);
                    if (curFirst == null) {
                        curFirst = newNode;
                    }
                    if (curTail != null) {
                        curTail.setLeftNode(newNode);
                    }
                    curTail = newNode;
                }
            }
        }
        return head;
    }

    private static boolean compareModel(Model m1, Model m2, int i) {
        for (int j = 0; j <= i; j++) {
            if (m1.getTypeIndex(j) == null || m2.getTypeIndex(j) == null || !m1.getTypeIndex(j).equals(m2.getTypeIndex(j))) {
                return false;
            }
        }
        return true;
    }

    private static ModelTreeNode searchParent(ModelTreeNode head, Model model, int level) {
        ModelTreeNode pre = head;
        for (int j = 0; j <= level; j++) {
            for (int i = 0; i < pre.children.size(); i++) {
                ModelTreeNode curChild = pre.children.get(i);
                if (curChild != null && curChild.name != null && curChild.name.equals(model.getTypeIndex(j))) {
                    pre = curChild;
                    break;
                }
            }
        }
        return pre;
    }


    static class Model {
        String type1;
        String type2;
        String type3;
        String type4;
        String type5;
        String type6;
        String type7;
        String type8;
        String type9;
        String type10;

        public Model() {
        }

        public Model(String type1, String type2, String type3, String type4, String type5, String type6, String type7, String type8, String type9, String type10) {
            this.type1 = type1;
            this.type2 = type2;
            this.type3 = type3;
            this.type4 = type4;
            this.type5 = type5;
            this.type6 = type6;
            this.type7 = type7;
            this.type8 = type8;
            this.type9 = type9;
            this.type10 = type10;
        }

        public String getTypeIndex(final int i) {
            switch (i + 1) {
                case 1:
                    return type1;
                case 2:
                    return type2;
                case 3:
                    return type3;
                case 4:
                    return type4;
                case 5:
                    return type5;
                case 6:
                    return type6;
                case 7:
                    return type7;
                case 8:
                    return type8;
                case 9:
                    return type9;
                case 10:
                    return type10;
                default:
                    return null;
            }
        }
    }

    static class ModelTreeNode {
        String name;
        List<ModelTreeNode> children = new ArrayList<>();
        ModelTreeNode leftNode;
        Model model;

        public ModelTreeNode(String name, Model model) {
            this.name = name;
            this.model = model;
        }

        public void addChild(ModelTreeNode child) {
            children.add(child);
        }

        public ModelTreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(ModelTreeNode leftNode) {
            this.leftNode = leftNode;
        }
    }
}
