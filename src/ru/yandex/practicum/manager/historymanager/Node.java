package ru.yandex.practicum.manager.historymanager;



class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {

        this.item = element;
        this.next = next;
        this.prev = prev;
    }

}