package codeping.flex.stock.adapter.out.persistence.mapper.common;

public interface ReadOnlyEntityMapper<ENTITY, DOMAIN> {

    DOMAIN toDomain(final ENTITY entity);
}