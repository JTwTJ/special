package com.jwt.special.model.vo;

import com.jwt.special.model.Links;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author jiangwentao
 * @date 2019/1/3 0003 下午 2:44
 */
@Data
public class LinksVo extends Links implements Comparable<LinksVo> {

    private static final long serialVersionUID = -6409102381889400859L;
    private List<LinksVo> children;

    public static LinksVo convert(Links link) {
        LinksVo linksVo = new LinksVo();
        BeanUtils.copyProperties(link, linksVo);
        return linksVo;
    }

    public static LinksVo convert(Links link, List<LinksVo> children) {
        LinksVo vo = convert(link);
        vo.setChildren(children);
        return vo;
    }

    @Override
    public int compareTo(LinksVo o) {
        String linkIdCompare = o.getLinkId();
        return o.getLinkId().compareTo(linkIdCompare);
    }
}
