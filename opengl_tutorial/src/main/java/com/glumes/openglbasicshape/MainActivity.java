package com.glumes.openglbasicshape;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.glumes.databindingadapter.DataBindingAdapter;
import com.glumes.databindingadapter.Items;
import com.glumes.openglbasicshape.activitiy.BasicGraphActivity;
import com.glumes.openglbasicshape.activitiy.BasicShapeActivity;
import com.glumes.openglbasicshape.imageprocessing.ImageProcessingActivity;
import com.glumes.openglbasicshape.obj.ImportObjectActivity;
import com.glumes.openglbasicshape.move.RotateAndMoveActivity;
import com.glumes.openglbasicshape.activitiy.TextureActivity;
import com.glumes.openglbasicshape.filter.GLSurfaceViewFilterActivity;
import com.glumes.openglbasicshape.scissor.ScissorAndTestActivity;
import com.glumes.openglbasicshape.utils.RenderType;
import com.glumes.openglbasicshape.viewholderitem.RenderBinder;
import com.glumes.openglbasicshape.viewholderitem.RenderModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvRenderer)
    RecyclerView rvRenderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renderer);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvRenderer.setLayoutManager(layoutManager);

        Items items = new Items();

        DataBindingAdapter mAdapter = new DataBindingAdapter();
        mAdapter
                .map(RenderModel.class, new RenderBinder())
                .setItems(items);

        rvRenderer.setAdapter(mAdapter);

//        items.add(new RenderModel("绘制篇", RenderType.RENDER_TYPE_TITLE));

        items.add(new RenderModel("基本图形的绘制", RenderType.RENDER_TYPE_JUMP_ACTIVITY, BasicGraphActivity.class));

        items.add(new RenderModel("基本形状的绘制", RenderType.RENDER_TYPE_JUMP_ACTIVITY, BasicShapeActivity.class));

        items.add(new RenderModel("绘制纹理", RenderType.RENDER_TYPE_JUMP_ACTIVITY, TextureActivity.class));

        items.add(new RenderModel("旋转与移动篇", RenderType.RENDER_TYPE_JUMP_ACTIVITY, RotateAndMoveActivity.class));

        items.add(new RenderModel("滤镜篇", RenderType.RENDER_TYPE_TITLE));


        items.add(new RenderModel("FBO 使用", RenderType.RENDER_TYPE_JUMP_ACTIVITY));
        items.add(new RenderModel("基于GLSurfaceView的滤镜", RenderType.RENDER_TYPE_JUMP_ACTIVITY, GLSurfaceViewFilterActivity.class));

//        items.add(new RenderModel("图像处理篇", RenderType.RENDER_TYPE_TITLE));

        items.add(new RenderModel("着色器图像处理", RenderType.RENDER_TYPE_JUMP_ACTIVITY, ImageProcessingActivity.class));

//        items.add(new RenderModel("模型导入偏", RenderType.RENDER_TYPE_TITLE));

        items.add(new RenderModel("裁剪与测试", RenderType.RENDER_TYPE_JUMP_ACTIVITY, ScissorAndTestActivity.class));

        items.add(new RenderModel("3D 模型导入", RenderType.RENDER_TYPE_JUMP_ACTIVITY, ImportObjectActivity.class));

//        items.add(new RenderModel("编解码篇", RenderType.RENDER_TYPE_TITLE));

        items.add(new RenderModel("相机录制", RenderType.RENDER_TYPE_JUMP_ACTIVITY, CameraRawDataCodecActivity.class));

    }


}
