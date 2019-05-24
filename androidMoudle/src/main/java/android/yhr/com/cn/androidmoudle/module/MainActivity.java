package android.yhr.com.cn.androidmoudle.module;

import android.Manifest;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.yhr.com.cn.androidmoudle.R;
import android.yhr.com.cn.androidmoudle.databinding.ActivityMainBinding;
import android.yhr.com.cn.commonmoudle.base.BaseActivity;
import android.yhr.com.cn.commonmoudle.common.RouterPath;

import com.alibaba.android.arouter.facade.annotation.Route;

import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by yhr on 19-5-20.
 */
@Route(path = RouterPath.WanAndroidRouterPath.PATH_MAIN_ACTIVITY)
public class MainActivity extends BaseActivity<ActivityMainBinding> {
//    private HomeFragment mHomeFragment;
//    private TreeFragment mTreeFragment;
//
//    private DownloadManagerUtils mDownloadManagerUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        reqRuntimePermission();

//        registerRxBus();
//
        initView();
    }


    /**
     * 获取动态权限
     */
    private void reqRuntimePermission() {
        String[] runtimePermission = {Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.READ_PHONE_STATE, Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO,Manifest.permission.REQUEST_INSTALL_PACKAGES};
        if (EasyPermissions.hasPermissions(this, runtimePermission)) {
            // 已经申请过权限，做想做的事
        } else {
            // 没有申请过权限，现在去申请
            EasyPermissions.requestPermissions(this, "没有授予权限将导致某些功能异常", 2, runtimePermission);
        }
    }

    private void initView() {

//        setTitle("玩Android");
//        setNavigationIcon(R.drawable.ic_menu);
//
//        showFragment(1);
//        mDownloadManagerUtil = new DownloadManagerUtils(this);
//
//        initListener();
//
//        initDrawerToggle();
//
//        initNavHeader();
    }

    /**
     * 显示fragment
     *
     * @param id 导航按钮id
     */
//    private void showFragment(int id) {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        hindFragment(transaction);
//        switch (id) {
//            case 1:
//                if (mHomeFragment != null) {
//                    transaction.show(mHomeFragment);
//                } else {
//                    mHomeFragment = new HomeFragment();
//                    transaction.add(R.id.content, mHomeFragment);
//                }
//                break;
//            case 2:
//                if (mTreeFragment != null) {
//                    transaction.show(mTreeFragment);
//                } else {
//                    mTreeFra private HomeFragment mHomeFragment;
//    private TreeFragment mTreeFragment;
//
//    private DownloadManagerUtils mDownloadManagerUtil;gment = new TreeFragment();
//                    transaction.add(R.id.content, mTreeFragment);
//                }
//                break;
//            // 添加default
//            default:
//                break;
//        }
//        transaction.commit();
//    }
//
//    /**
//     * 隐藏fragment
//     *
//     * @param transaction
//     */
//    private void hindFragment(FragmentTransaction transaction) {
//        if (mHomeFragment != null) {
//            transaction.hide(mHomeFragment);
//        }
//
//        if (mTreeFragment != null) {
//            transaction.hide(mTreeFragment);
//        }
//
//    }
}
