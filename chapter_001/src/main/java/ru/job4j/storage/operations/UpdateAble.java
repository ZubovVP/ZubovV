package ru.job4j.storage.operations;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $Id$.
 * Date: 09.04.2020.
 */
public interface UpdateAble<T> {
    boolean update(T element);
}
