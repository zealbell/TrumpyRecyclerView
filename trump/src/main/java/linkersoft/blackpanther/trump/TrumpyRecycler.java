package linkersoft.blackpanther.trump;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;


public  class TrumpyRecycler extends RecyclerView {


    public TrumpyRecycler(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        in(context, attrs);
    }
    public TrumpyRecycler(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        in(context, attrs);
    }

    @Override
    protected float getTopFadingEdgeStrength() {
        return TopFadingEdgeStrength;
    }
    @Override
    protected float getBottomFadingEdgeStrength() {
        return BottomFadingEdgeStrength;
    }
    @Override
    public float getLeftFadingEdgeStrength(){
        return LeftFadingEdgeStrength;
    }
    @Override
    public float getRightFadingEdgeStrength() {
        return RightFadingEdgeStrength;
    }
    @Override
    public void setLayoutManager(LayoutManager layout) {
        super.setLayoutManager(layout);
        if(layout instanceof TrumpyLinearLayoutManager)LLM =(TrumpyLinearLayoutManager)layout;
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        this.adapter=adapter;
    }

    @Override
    public boolean fling(int velocityX, int velocityY) {
        velocityY= Math.round(velocityY* FLING_FACTOR);
        return super.fling(velocityX, velocityY);
    }
    protected void in(Context context, AttributeSet attrs){
        TypedArray All_attrs =context.getTheme().obtainStyledAttributes(attrs, R.styleable.TrumpyRecycler, 0, 0);
        try{ TopFadingEdgeStrength=All_attrs.getFloat(R.styleable.TrumpyRecycler_TopFadingEdgeStrength,0);
             BottomFadingEdgeStrength=All_attrs.getFloat(R.styleable.TrumpyRecycler_BottomFadingEdgeStrength,0);
             LeftFadingEdgeStrength=All_attrs.getFloat(R.styleable.TrumpyRecycler_LeftFadingEdgeStrength,0);
             RightFadingEdgeStrength=All_attrs.getFloat(R.styleable.TrumpyRecycler_RightFadingEdgeStrength,0);
        }finally{All_attrs.recycle();}
    }


    public static final float FAST_FLING=1,MODERATE_FLING=0.5F,SLOW_FLING=0.1F,NO_FLING=0F;
    public static final int HIGH_FRICTION=15,MODERATE_FRICTION=10,LOW_FRICTION=5,NO_FRICTION=1;


    private float FLING_FACTOR =NO_FLING;
    private TrumpyLinearLayoutManager LLM;
    private float TopFadingEdgeStrength,BottomFadingEdgeStrength,LeftFadingEdgeStrength,RightFadingEdgeStrength;
    private Adapter adapter;

    public void setFrictionFactor(int FRICTION_FACTOR){
        if(LLM!=null)LLM.FRICTION_FACTOR = FRICTION_FACTOR;
    }
    public void setFlingFactor(float FLING_FACTOR){
        this.FLING_FACTOR = FLING_FACTOR;
    }
    public void setFadingEdgeStrengths(float TopFadingEdgeStrength,float BottomFadingEdgeStrength,float LeftFadingEdgeStrength,float RightFadingEdgeStrength){
        this.TopFadingEdgeStrength=TopFadingEdgeStrength;
        this.BottomFadingEdgeStrength=BottomFadingEdgeStrength;
        this.LeftFadingEdgeStrength=LeftFadingEdgeStrength;
        this.RightFadingEdgeStrength=RightFadingEdgeStrength;
    }

    public void setChatMode(){
        LLM.setStackFromEnd(true);
    }
    public void scrollToBottom(){
        if(adapter!=null)scrollToPosition(adapter.getItemCount()-1);
    }
    public void NotifyDataSetChanged(){
        if(adapter==null)return;
        post(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
    }

    public int getFirstVisibleItemPosition(){
        return (LLM!=null)?LLM.findFirstVisibleItemPosition():-1;
    }
    public int getLastVisibleItemPosition(){
        return (LLM!=null)?LLM.findLastVisibleItemPosition():-1;
    }
    public int getCentrallyVisibleItemPosition(){
        int first=getFirstVisibleItemPosition();
        return first+((getLastVisibleItemPosition()-first)/2);
    }
    public int getFirstCompletelyVisibleItemPosition(){
        return (LLM!=null)?LLM.findFirstCompletelyVisibleItemPosition():-1;
    }
    public int getLastCompletelyVisibleItemPosition(){
        return (LLM!=null)?LLM.findLastCompletelyVisibleItemPosition():-1;
    }
    public View getView(int position){
        return (LLM!=null)?LLM.findViewByPosition(position):null;
    }

    @Override
    public String toString() {
        return "@LiNKeR(>_<)~"+super.toString();
    }

    public static class TrumpyLinearLayoutManager extends LinearLayoutManager {

        private  int FRICTION_FACTOR =NO_FRICTION;//a val of 1 reakky does noffyn
        public TrumpyLinearLayoutManager(Context context) {
            super(context);
        }
        public TrumpyLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
            super(context, orientation, reverseLayout);
        }
        public TrumpyLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        @Override
        public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
            return super.scrollVerticallyBy(dy/ FRICTION_FACTOR, recycler, state);
        }

        @Override
        public void onLayoutCompleted(State state) {
            super.onLayoutCompleted(state);
        }

        @Override
        public void onLayoutChildren(Recycler recycler, State state) {
            super.onLayoutChildren(recycler, state);
        }

        @Override
        public void onMeasure(Recycler recycler, State state, int widthSpec, int heightSpec) {
            super.onMeasure(recycler, state, widthSpec, heightSpec);
        }

        @Override
        public String toString() {
            return "@LiNKeR(>_<)~"+super.toString();
        }

    }
}

