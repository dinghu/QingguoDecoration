package com.qing.guo.decoration.ui.fragment;

import android.net.Uri;
import android.util.Log;
import android.view.View;

import com.fkh.support.ui.fragment.BaseFragment;
import com.fkh.support.ui.widget.TitleView;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.ui.activity.chat.ChatContractActivity;
import com.qing.guo.decoration.utils.ActivityUtils;

import butterknife.BindView;
import io.rong.imkit.RongIM;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;

public class ChatFragment extends BaseFragment {
    @BindView(R.id.titleView)
    TitleView titleView;

    @Override
    protected int getLayoutId() {
        return R.layout.conversationlist;
    }

    @Override
    protected void initView(View view) {
        titleView.setOnClickRightListener(new TitleView.OnClickRightListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.startActivity(getContext(),ChatContractActivity.class);
            }
        });
        enterFragment();
    }

    /**
     * 加载 会话列表 ConversationListFragment
     */
    private void enterFragment() {

        ConversationListFragment fragment = (ConversationListFragment) getChildFragmentManager().findFragmentById(R.id.conversationlist);

        Uri uri = Uri.parse("rong://" + getContext().getApplicationInfo().packageName).buildUpon()
                .appendPath("conversationlist")
                .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话非聚合显示
                .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "true")//设置群组会话聚合显示
                .appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "false")//设置讨论组会话非聚合显示
                .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "false")//设置系统会话非聚合显示
                .build();

        fragment.setUri(uri);
    }
}
