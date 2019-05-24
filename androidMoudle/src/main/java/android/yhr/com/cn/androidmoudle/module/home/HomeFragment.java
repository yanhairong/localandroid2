//package android.yhr.com.cn.androidmoudle.module.home;
//
//import android.arch.lifecycle.ViewModelProviders;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.view.View;
//import android.yhr.com.cn.androidmoudle.R;
//
//import com.chad.library.adapter.base.BaseQuickAdapter;
//import com.youth.banner.Banner;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 首页
// */
//public class HomeFragment extends BaseSmartRefreshFragment<ArticleBean.DatasBean> {
//
//    private HomeViewModel mHomeViewModel;
//
//    ArticleAdapter mArticleAdapter;
//
//    private List<BannerBean> mBannerList;
//    private ArrayList<String> mImagePaths;
//    private ArrayList<String> mBannerTitles;
//
//    private Banner mBanner;
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        initView();
//        onRefresh();
//    }
//
//    private void initView() {
//
//        mImagePaths = new ArrayList<>();
//        mBannerTitles = new ArrayList<>();
//
//        mHomeViewModel = ViewModelProviders.of(HomeFragment.this).get(HomeViewModel.class);
//        mArticleAdapter = new ArticleAdapter(R.layout.item_home_list, mList);
//        setAdapter(mArticleAdapter);
//
//        View view = getActivity().getLayoutInflater().inflate(R.layout.item_banner, null, false);
//        mBanner = view.findViewById(R.id.banner);
//        mArticleAdapter.addHeaderView(view);
//    }
//
//    @Override
//    public void onRefresh() {
//        super.onRefresh();
//        getBannerData();
//    }
//
//    @Override
//    protected boolean needDividerDecoration() {
//        return true;
//    }
//
//    @Override
//    protected void getData() {
//        mHomeViewModel.queryArticle(mPageNo)
//                .observe(HomeFragment.this, this::dealArticleList);
//    }
//
//    private void getBannerData() {
//        mHomeViewModel.getBanner()
//                .observe(HomeFragment.this, this::dealBanner);
//    }
//
//    private void setBannerAdapter() {
//        mBanner
//                .setImages(mImagePaths)
//                .setImageLoader(new GlideImageLoader())
//                .setBannerTitles(mBannerTitles)
//                .setOnBannerListener(position -> {}
//                )
//                .start();
//    }
//
//    /**
//     * 处理文章列表数据
//     */
//    private void dealArticleList(Resource<ArticleBean> articleBeanResource) {
//        Status status = articleBeanResource.status;
//
//        if (status == Status.SUCCESS) {
//            ArticleBean data = articleBeanResource.data;
//            if (data == null) {
//                HomeFragment.this.dealWithData(null, status);
//            } else {
//                HomeFragment.this.dealWithData(data.getDatas(), status);
//            }
//        }
//
//        if (status == Status.ERROR || status == Status.FAILURE) {
//            HomeFragment.this.dealWithData(null, status);
//        }
//    }
//
//    /**
//     * 处理banner 数据
//     */
//    private void dealBanner(Resource<List<BannerBean>> listResource) {
//        switch (listResource.status) {
//            case SUCCESS:
//                mBannerList = listResource.data;
//                mImagePaths.clear();
//                mBannerTitles.clear();
//                for (int i = 1; i < mBannerList.size(); i++) {
//                    mImagePaths.add(mBannerList.get(i).getImagePath());
//                    mBannerTitles.add(mBannerList.get(i).getTitle());
//                }
//                setBannerAdapter();
//
//                break;
//
//            case LOADING:
//                break;
//
//            case ERROR:
//                break;
//
//            case FAILURE:
//                break;
//
//            default:
//                break;
//        }
//
//    }
//
//    @Override
//    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//        super.onItemClick(adapter, view, position);
//        ArticleBean.DatasBean article = mList.get(position);
//        goWebView(article.getTitle(), article.getLink());
//    }
//
//    private void goWebView(String title, String link) {
//        Intent intent = new Intent(getContext(), WebActivity.class);
//        intent.putExtra(Constants.EXTRA_WEB_TITLE, title);
//        intent.putExtra(Constants.EXTRA_WEB_URL, link);
//        startActivity(intent);
//    }
//
//}
