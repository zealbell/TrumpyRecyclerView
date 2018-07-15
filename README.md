[![Project Status: Active - Initial development has started, usable release; work hasn't been stopped ](http://www.repostatus.org/badges/0.1.0/active.svg)](http://www.repostatus.org/#active)

TumpyRecyclerView
=============
A simpler and easy to use RecyclerView with more control +the function of recycling the Trump way added.

> *public-methods*

```java
     public void setFrictionFactor(int FRICTION_FACTOR)// HIGH_FRICTION=15,MODERATE_FRICTION=10,LOW_FRICTION=5,NO_FRICTION=1
     public void setFlingFactor(float FLING_FACTOR)// FAST_FLING=1,MODERATE_FLING=0.5F,SLOW_FLING=0.1F,NO_FLING=0F
     public void setFadingEdgeStrengths(float TopFadingEdgeStrength,float BottomFadingEdgeStrength,float LeftFadingEdgeStrength,float RightFadingEdgeStrength)
     public void setChatMode()// set items to be added in a chat-transcript mode
     public void scrollToBottom()
     public void NotifyDataSetChanged() //notifies that the dataset changed when the RecyclerView is not drawing/scrolling
     public int getFirstVisibleItemPosition()
     public int getLastVisibleItemPosition()
     public int getCentrallyVisibleItemPosition()
     public int getFirstCompletelyVisibleItemPosition()
     public int getLastCompletelyVisibleItemPosition()
     public View getView(int position)
```

> *public-static-class*

```java
  TrumpyLinearLayoutManager{...}// extends LinearLayoutManager and is responsible for controlling the friction of the TumpyRecyclerView
```

## Quick Start

> Gradle

```xml
   dependencies {
       implementation 'com.github.54LiNKeR:TrumpyRecyclerView:1.trump.2'
   }
```

> XML

```xml
    <linkersoft.blackpanther.trump.TrumpyRecycler
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:LeftFadingEdgeStrength="0.4935"
        app:TopFadingEdgeStrength="0"
        app:RightFadingEdgeStrength="0.4935"
        app:BottomFadingEdgeStrength="0"/>
```

> Activity

```java
          TrumpyRecycler trump=(TrumpyRecycler)findViewById(R.id.trump);
          //LAYOUT
          TrumpyRecycler.TrumpyLinearLayoutManager tllm= new TrumpyRecycler.TrumpyLinearLayoutManager(context);
          tllm.setOrientation(LinearLayoutManager.VERTICAL);
          trump.setLayoutManager(tllm);
          trump.setFlingFactor(TrumpyRecycler.MODERATE_FLING);
          trump.setFrictionFactor(TrumpyRecycler.NO_FRICTION);
          trump.setOverScrollMode(TrumpyRecycler.OVER_SCROLL_NEVER);
          //ADAPTER
          YourAdapter trumpdapter=new YourAdapter();
          trump.setAdapter(trumpdapter);
```


