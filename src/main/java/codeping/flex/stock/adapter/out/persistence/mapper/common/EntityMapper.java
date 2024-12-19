package codeping.flex.stock.adapter.out.persistence.mapper.common;

public interface EntityMapper<ENTITY, DOMAIN> {

    ENTITY toEntity(final DOMAIN domain);

    DOMAIN toDomain(final ENTITY entity);
}