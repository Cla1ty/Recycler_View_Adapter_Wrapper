# RecyclerView Adapter
Wrapper for RecyclerView Adapter

## Library

```
recyclerview/libs/com.dwiariyanto.recyclerview-${version}.aar
```

## Dependency

```
copy file arr to ${your_module}/libs/

open build.gradle and add this line
  implementation fileTree(include: ['*.aar'], dir: 'libs')
```

## Function

Setup item view to pair between model & layout
```kotlin
class MultiItemHorizontalItem
@Inject constructor()
: BaseItemView<MultiItemHorizontalModel>(
		MultiItemHorizontalModel::class.java,
		R.layout.item_horizontal
)
```

Setup adapter to determine which items are supported
```kotlin
class MultiItemHorizontalAdapter
@Inject constructor(
		horizontalItem: MultiItemHorizontalItem,
		horizontalMoreItem: MultiItemHorizontalMoreItem
) : BaseRecyclerViewAdapter(
		horizontalItem,
		horizontalMoreItem
)
```

## Change Log
```
2.2.1
+ No More Data
+ Duplicate prediction

2.2.0
+ LoadMore

2.1.2
~ RCA: Fix Bug ItemDecoration + DiffUtils
+ ItemDecoration (Replacement for GridSpanContentDecoration & LinearSpanContentDecoration)
~ Build RecyclerView on Attach Event
+ OnRecycler

2.1.1
~ fix bug LinearSpanContentDecoration Horizontal
~ fix bug ItemDecoration + DiffUtils
- IRecyclerViewData

2.1.0
- re-code (for best practice on kotlin)

2.0.0
- change language from java to kotlin
```
