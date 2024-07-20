package ProvaPassada2UN

class Questão1 {
    fun sort() {
        if (head == null || head?.next == null) {
            return
        }

        var current: Node?
        var index: Node?
        var temp: Int

        current = head
        while (current != null) {
            index = current.next
            while (index != null) {
                if (current.value > index.value) {
                    temp = current.value
                    current.value = index.value
                    index.value = temp
                }
                index = index.next
            }
            current = current.next
        }
    }
}