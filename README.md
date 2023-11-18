# Preferred Order List

List that maintains the preferred order.

The task is described by r0mko in this [tweet](https://twitter.com/r0mko/status/1725977540139876574) (translated by deepl):

> Here's a problem for you to think about from real life, not from this leetcode 
> of yours. It has been solved in my project for a long time already, but Chat GPT 
> suffers a crushing fiasco and babbles unspeakable nonsense.
>
> I wonder if someone can offer an elegant solution - I've done it quite trivially
>
> In general, the task is to create a list type storage where items are placed together with the desired
> position in this list, let's call this parameter 'order'. It is optional, if it is not 
> specified, the items are simply added to the end. Items that have order specified 
> tend to occupy the specified position in the list, displacing items that do not have 
> order if necessary.
>
> Illustration for clarification:
> ```
> list: []
> 1. insert (A, -) (no order specified)
> list: [ (A -) ]
> 2. insert (B, 1) (order = 1)
>    list: [ (A -) (B 1) ]
> 3. insert (C, 0)
>    list: [ (C 0) (B 1) (A -) ]  <- A is pushed to the end, now everything is in its desired places
> 4. insert (D, -)
>    list: [ (C 0) (B 1) (A -) (D -) ]
> 5. insert (E, 3)
>    list: [ (C 0) (B 1) (A -) (E 3) (D -) ]
> ```
> Items with conflicting order are inserted after the last item with the same order: 
>```
> 6. insert (F, 1)
> list: [ (C 0) (B 1) (F 1) (E 3) (A -) (D -) ]
>```
> Elements can have their order changed:
> ```
> 7. setOrder (F, 4)
>      list: [ (C 0) (B 1) (A -) (E 3) (F 4) (D -) ]
> 8. setOrder (E, -)
>    list: [ (C 0) (B 1) (A -) (E -) (F 4) (D -) ]
> 9. setOrder (D, 2)
>    list: [ (C 0) (B 1) (D 2) (A -) (F 4) (E -) ]
> ```
> Elements can be temporarily hidden from the list:
> ```
> 10. hide (A)
>     list: [ (C 0) (B 1) (D 2) (E -) (F 4) ]
> 11. hide (D)
>    list: [ (C 0) (B 1) (E -) (F 4) ]
> 12. hide (C)
>     list: [ (E -) (B 1) (F 4) ]
> ```
> When elements return, even if they have no order specified, they should appear in the same position from which they were hidden if possible, subject to subsequent list changes, but should primarily ensure that elements with order are in their desired positions:
> ```
> 11. unhide (D)
> list: [ (E -) (B 1) (D 2) (F 4) ]
> 12. unhide (A)
>     list: [ (A -) (B 1) (D 2) (E -) (F 4) ] <- A would like to be after D, but it needs to occupy position 0 in order for B and D to be in their positions
> 13. unhide (C)
>     list: [ (C 0) (B 1) (D 2) (A -) (F 4) (E -) ] <- A is now back where it was hidden
> ```

[continued](https://twitter.com/r0mko/status/1725981453094183409):

> Ah yes, forgot to specify the usage profile for performance optimization:
> 1. Reading from a list by index: very often
> 2. Inserting: once. Deleting: almost never, I even did an illustration.
> 3. Hide/return: sometimes
> 4. change order: rarely

