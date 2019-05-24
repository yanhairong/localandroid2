package android.yhr.com.cn.commonmoudle.base;

import android.content.pm.ActivityInfo;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.yhr.com.cn.commonmoudle.R;
import android.yhr.com.cn.commonmoudle.common.RouterPath;
import android.yhr.com.cn.commonmoudle.databinding.ActivityBaseBinding;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by yhr on 19-5-20.
 */
public class BaseActivity<B extends ViewDataBinding> extends AppCompatActivity{
    protected B mBinding;
    protected ActivityBaseBinding mBaseBinding;

    protected <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mBaseBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_base, null, false);
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, null, false);

        // content
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mBinding.getRoot().setLayoutParams(params);
        RelativeLayout mContainer = (RelativeLayout) mBaseBinding.getRoot().findViewById(R.id.rl_container);
        mContainer.addView(mBinding.getRoot());
        getWindow().setContentView(mBaseBinding.getRoot());

        setToolBar();


        // 设置强制竖屏显示
        if(isChangeOrientationToPortrait()){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

    }

    /**
     * 是否强制竖屏
     * @return
     */
    public boolean isChangeOrientationToPortrait(){
        return true;
    }

    /**
     * 设置titlebar
     */
    protected void setToolBar() {
        setSupportActionBar(mBaseBinding.toolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
        }
        setNavigationOnClickListener();
    }

    protected void setNavigationOnClickListener() {
        mBaseBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void setTitle(CharSequence text) {
        mBaseBinding.toolBar.setTitle(text);
    }

    public void setSubtitle(CharSequence text) {
        mBaseBinding.toolBar.setSubtitle(text);
    }

    public void setNavigationIcon(int resId) {
        mBaseBinding.toolBar.setNavigationIcon(resId);
    }

    public void setCenterTitle(CharSequence text) {
        mBaseBinding.tvTitle.setVisibility(View.VISIBLE);
        mBaseBinding.tvTitle.setText(text);
    }

    protected void showLoading() {
        mBaseBinding.pbLoading.setVisibility(View.VISIBLE);
        mBaseBinding.ivEmpty.setVisibility(View.GONE);
        mBaseBinding.ivError.setVisibility(View.GONE);
    }

    protected void showContent() {
        mBaseBinding.pbLoading.setVisibility(View.GONE);
        mBaseBinding.ivEmpty.setVisibility(View.GONE);
        mBaseBinding.ivError.setVisibility(View.GONE);
    }

    protected void showEmpty() {
        mBaseBinding.pbLoading.setVisibility(View.GONE);
        mBaseBinding.ivEmpty.setVisibility(View.VISIBLE);
        mBaseBinding.ivError.setVisibility(View.GONE);
    }

    protected void showError() {
        mBaseBinding.pbLoading.setVisibility(View.GONE);
        mBaseBinding.ivEmpty.setVisibility(View.GONE);
        mBaseBinding.ivError.setVisibility(View.VISIBLE);
    }


}
