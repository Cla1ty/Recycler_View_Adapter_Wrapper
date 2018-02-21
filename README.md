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
