package android.yhr.com.cn.commonmoudle.common;

/**
 * 路由路径
 * <p>
 * 不同组件中的路径在不同的静态内部类中，不同组件中的组名不能相同，（即第一级名字不能相同）
 *
 * @author 李立
 * @date 2018/2/7
 */
public class RouterPath {

    public static class BlogRouterPath {
        public static final String PATH_BLOG = "/blog/search";
    }

    public static class KnowledgeRouterPath {

        public static final String PATH_KNOWLEDGE_LIST = "/knowledge/list";

        public static final String PATH_CARDNO = "/knowledge/path/cardno";
        public static final String PATH_RXJAVA = "/knowledge/path/rxjava";
        public static final String PATH_SPEECH = "/knowledge/path/speech";
        public static final String PATH_CALENDAR = "/knowledge/path/calendar";
    }

    public static class WanAndroidRouterPath {

        public static final String PATH_MAIN_ACTIVITY = "/wan/main/mainactivity";

        public static final String PATH_TREE_ARTICLE = "/wan/module/tree/treeArticleActivity";

        public static final String PATH_LOGIN = "/wan/user/login_activity";
        /**
         * 关于我们
         */
        public static final String PATH_ABOUT_US = "/wan/com/about/aboutActivity";

        public static final String PATH_RX_TEST = "/wan/module/test";

        public static final String PATH_TEST2 = "/wan/test/test2";

        public static final String PATH_HOTKEY = "/wan/module/hotkey";

    }

    public static class CommonRouterPath {
        public static final String PATH_COMMON_WEBVIEW = "/common/webview";
    }

}
